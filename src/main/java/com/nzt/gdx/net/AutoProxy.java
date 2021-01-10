package com.nzt.gdx.net;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

/**
 * Used to detect and add proxy on net modules only for desktop ? //TODO test android/IOS
 */
public class AutoProxy {

	public static void init() {
		try {
			System.setProperty("java.net.useSystemProxies", "true");
			List<Proxy> l = ProxySelector.getDefault().select(new URI("http://www.yahoo.com/"));

			for (Iterator<Proxy> iter = l.iterator(); iter.hasNext();) {

				Proxy proxy = iter.next();
				TagLogger.error(LogTagsBase.NET, "Proxy", "type : " + proxy.type());

				InetSocketAddress addr = (InetSocketAddress) proxy.address();
				if (addr == null) {
					TagLogger.error(LogTagsBase.NET, "Proxy", "no proxy");
				} else {
					TagLogger.error(LogTagsBase.NET, "Proxy", "hostname : " + addr.getHostName());
					TagLogger.error(LogTagsBase.NET, "port : " + addr.getPort());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
