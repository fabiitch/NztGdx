package com.nzt.gdx.net;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;

/**
 * Used to detect and add proxy on net modules
 * @author fabiitch
 *
 */
public class AutoProxy {

	public static void init() {
		try {
			System.setProperty("java.net.useSystemProxies", "true");
			List<Proxy> l = ProxySelector.getDefault().select(new URI("http://www.yahoo.com/"));

			for (Iterator<Proxy> iter = l.iterator(); iter.hasNext();) {

				Proxy proxy = iter.next();
				Gdx.app.log("AutoProxy", "type : " + proxy.type());

				InetSocketAddress addr = (InetSocketAddress) proxy.address();
				if (addr == null) {
					Gdx.app.log("AutoProxy", "No Proxy");
				} else {
					Gdx.app.log("AutoProxy", "hostname : " + addr.getHostName());
					Gdx.app.log("AutoProxy", "port : " + addr.getPort());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
