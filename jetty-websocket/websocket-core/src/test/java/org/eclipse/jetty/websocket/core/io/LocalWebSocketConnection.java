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

package org.eclipse.jetty.websocket.core.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.websocket.core.api.WebSocketConnection;
import org.eclipse.jetty.websocket.core.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.core.protocol.CloseInfo;
import org.eclipse.jetty.websocket.core.protocol.ConnectionState;
import org.junit.rules.TestName;

public class LocalWebSocketConnection implements WebSocketConnection
{
    private final String id;
    private WebSocketPolicy policy = WebSocketPolicy.newServerPolicy();
    private boolean open = false;

    public LocalWebSocketConnection()
    {
        this("anon");
    }

    public LocalWebSocketConnection(String id)
    {
        this.id = id;
    }

    public LocalWebSocketConnection(TestName testname)
    {
        this.id = testname.getMethodName();
    }

    @Override
    public void close()
    {
        open = false;
    }

    @Override
    public void close(int statusCode, String reason)
    {
        open = false;
    }

    @Override
    public void disconnect()
    {
        open = false;
    }

    @Override
    public WebSocketPolicy getPolicy()
    {
        return policy;
    }

    @Override
    public InetSocketAddress getRemoteAddress()
    {
        return null;
    }

    @Override
    public ConnectionState getState()
    {
        return null;
    }

    @Override
    public String getSubProtocol()
    {
        return null;
    }

    @Override
    public boolean isInputClosed()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isOpen()
    {
        return open;
    }

    @Override
    public boolean isOutputClosed()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isReading()
    {
        return false;
    }

    @Override
    public void onCloseHandshake(boolean incoming, CloseInfo close)
    {
        // TODO Auto-generated method stub
    }

    public void onOpen() {
        open = true;
    }

    @Override
    public <C> void ping(C context, Callback<C> callback, byte[] payload) throws IOException
    {
    }

    public void setPolicy(WebSocketPolicy policy)
    {
        this.policy = policy;
    }

    @Override
    public SuspendToken suspend()
    {
        return null;
    }

    @Override
    public String toString()
    {
        return String.format("%s[%s]",LocalWebSocketConnection.class.getSimpleName(),id);
    }

    @Override
    public <C> void write(C context, Callback<C> callback, byte[] buf, int offset, int len) throws IOException
    {

    }

    @Override
    public <C> void write(C context, Callback<C> callback, ByteBuffer buffer) throws IOException
    {

    }

    @Override
    public <C> void write(C context, Callback<C> callback, String message) throws IOException
    {

    }
}
