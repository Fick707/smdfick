package org.hraink.futures.jctp.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bridj.BridJ;
import org.bridj.Platform;
import org.hraink.futures.jctp.commons.CtpConstants;
import org.junit.Test;

/**
 * JCTPLibrary工具类
 * 
 * @author Hraink E-mail:Hraink@Gmail.com
 * @version 2013-1-28 下午9:24:01
 */

public class JCTPLibraryUtil {
	private static final Log log = LogFactory.getLog(JCTPLibraryUtil.class);

	private static final String OS_NAME = System.getProperty("os.name", "");

	private static boolean inited;

	private static final String CTP_NAME = "CTP_FICK";

	private static final String CTP_LIB_PATH = CtpConstants.getProperty("CTP_LIB_PATH");
	private static final String[] CTP_LIBS = CtpConstants.getPropertyValues("CTP_LIBS_FILE_NAMES");

	private static File extractedLibrariesTempDir;

	private static final int maxTempFileAttempts = 20;

	static {
		try {
			// 创建临时文件夹
			extractedLibrariesTempDir = createTempDir("CTPExtractedLibraries");
			log.debug(extractedLibrariesTempDir.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 初始加载动态链接库
	 */
	public static synchronized void initLibrary() {
		if (inited) {
			return;
		}

		for (String ctpLib : CTP_LIBS) {
			boolean loaded = false;
			String lib = null;

			if (!loaded) {
				String ctpLibFilePath = CTP_LIB_PATH + ctpLib;
				if (Platform.isWindows()) {
					ctpLibFilePath = ctpLibFilePath.concat(".dll");
				} else if (Platform.isLinux()) {
					// System.out.println("暂时不对linux提供支持");
				}
				try {
					File libFile = extractEmbeddedLibraryResource(ctpLibFilePath);
					if (libFile == null) {
						throw new FileNotFoundException(
								"Failed to extract embedded library '"
										+ ctpLibFilePath + ")");
					}

					System.load(lib = libFile.toString());
					BridJ.setNativeLibraryFile(ctpLib, libFile);
					loaded = true;
				} catch (IOException ex) {
					BridJ.error("Failed to load '" + CTP_NAME + "'", ex);
				}
				if (!loaded) {
					System.loadLibrary(ctpLib);
				}
			}
		}
		inited = true;
	}

	/**
	 * 释放链接库
	 */
	public static synchronized void release() {
		BridJ.releaseAll();

		for (String ctpLibName : CTP_LIBS) {
			unloadNativeLibs(ctpLibName);
		}

		for (File libraryFile : temporaryExtractedLibraryCanonicalFiles) {
			libraryFile.delete();
		}
	}

	private static File extractEmbeddedLibraryResource(String path)
			throws IOException {
		int len;
		byte[] b = new byte[8196];
		InputStream in = Platform.getResourceAsStream(path);
		if (in == null) {
			File f = new File(path);
			if (!f.exists()) {
				f = new File(f.getName());
			}
			if (f.exists()) {
				return f.getCanonicalFile();
			}
		}
		String fileName = new File(path).getName();
		File libFile = new File(extractedLibrariesTempDir, fileName);
		OutputStream out = new BufferedOutputStream(new FileOutputStream(
				libFile));
		while ((len = in.read(b)) > 0) {
			out.write(b, 0, len);
		}
		out.close();
		in.close();

		addTemporaryExtractedLibraryFileToDeleteOnExit(libFile);
		addTemporaryExtractedLibraryFileToDeleteOnExit(libFile.getParentFile());

		return libFile;
	}

	private static File createTempDir(String prefix) throws IOException {
		File dir;
		for (int i = 0; i < maxTempFileAttempts; i++) {
			dir = File.createTempFile(prefix, "");
			if (dir.delete() && dir.mkdirs()) {
				dir.deleteOnExit();
				return dir;
			}
		}
		throw new RuntimeException("Failed to create temp dir with prefix '"
				+ prefix + "' despite " + maxTempFileAttempts + " attempts!");
	}

	private static Set<File> temporaryExtractedLibraryCanonicalFiles = Collections
			.synchronizedSet(new LinkedHashSet<File>());

	private static void addTemporaryExtractedLibraryFileToDeleteOnExit(File file)
			throws IOException {
		File canonicalFile = file.getCanonicalFile();

		temporaryExtractedLibraryCanonicalFiles.add(canonicalFile);

		canonicalFile.deleteOnExit();
	}

	public static boolean isInited() {
		return inited;
	}

	private static void unloadNativeLibs(String dllName) {
		try {
			ClassLoader classLoader = JCTPLibraryUtil.class.getClassLoader();
			Field field = ClassLoader.class.getDeclaredField("nativeLibraries");
			field.setAccessible(true);
			Vector libs = (Vector) field.get(classLoader);
			Iterator it = libs.iterator();
			Object o;

			if (Platform.isWindows()) {
				dllName = dllName.concat(".dll");
			} else if (Platform.isLinux()) {
				// TODO linux
				// System.out.println("暂时不对linux提供支持");
			}

			while (it.hasNext()) {
				o = it.next();

				Field[] fs = o.getClass().getDeclaredFields();

				boolean hasInit = false;
				for (int k = 0; k < fs.length; k++) {
					if (fs[k].getName().equals("name")) {
						fs[k].setAccessible(true);
						String dllPath = fs[k].get(o).toString();
						if (dllPath.endsWith(dllName)) {
							hasInit = true;
						}
					}
				}

				if (hasInit) {
					Method finalize = o.getClass().getDeclaredMethod("finalize", new Class[0]);
					finalize.setAccessible(true);
					finalize.invoke(o, new Object[0]);
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Test
	public void test() {
		System.out.println(this.CTP_LIB_PATH);
		System.out.println(this.CTP_NAME);
		for (String t : this.CTP_LIBS) {
			System.out.println(t);
		}
	}

}
