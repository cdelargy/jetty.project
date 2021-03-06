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

package org.eclipse.jetty.websocket.core.extensions.mux.add;

import java.io.IOException;

import org.eclipse.jetty.websocket.core.extensions.mux.MuxChannel;
import org.eclipse.jetty.websocket.core.extensions.mux.MuxException;
import org.eclipse.jetty.websocket.core.io.WebSocketSession;

/**
 * Server interface, for dealing with incoming AddChannelRequest / AddChannelResponse flows.
 */
public interface MuxAddServer
{
    /**
     * Perform the handshake.
     * 
     * @param channel
     *            the channel to attach the {@link WebSocketSession} to.
     * @param requestHandshake
     *            the request handshake (request headers)
     * @return the response handshake (the response headers)
     * @throws MuxException
     *             if unable to handshake
     * @throws IOException
     *             if unable to parse request headers
     */
    String handshake(MuxChannel channel, String requestHandshake) throws MuxException, IOException;
}
