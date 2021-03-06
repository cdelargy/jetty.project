//
//  ========================================================================
//  Copyright (c) 1995-2012 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//


package org.eclipse.jetty.spdy.server.proxy;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.spdy.api.SPDY;
import org.eclipse.jetty.spdy.server.SPDYServerConnector;
import org.eclipse.jetty.util.ssl.SslContextFactory;

public class HTTPSPDYProxyConnector extends SPDYServerConnector
{
    public HTTPSPDYProxyConnector(Server server, ProxyEngineSelector proxyEngineSelector)
    {
        this(server, null, proxyEngineSelector);
    }

    public HTTPSPDYProxyConnector(Server server, SslContextFactory sslContextFactory, ProxyEngineSelector proxyEngineSelector)
    {
        super(server, sslContextFactory, proxyEngineSelector);
        addConnectionFactory(new ProxyHTTPConnectionFactory(new HttpConfiguration(), SPDY.V2, proxyEngineSelector));
    }
}
