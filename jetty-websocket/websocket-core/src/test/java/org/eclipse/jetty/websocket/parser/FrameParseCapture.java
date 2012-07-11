package org.eclipse.jetty.websocket.parser;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.WebSocketException;
import org.eclipse.jetty.websocket.protocol.OpCode;
import org.eclipse.jetty.websocket.protocol.WebSocketFrame;
import org.junit.Assert;

public class FrameParseCapture implements Parser.Listener
{
    private static final Logger LOG = Log.getLogger(FrameParseCapture.class);
    private List<WebSocketFrame> frames = new ArrayList<>();
    private List<WebSocketException> errors = new ArrayList<>();

    public void assertHasErrors(Class<? extends WebSocketException> errorType, int expectedCount)
    {
        Assert.assertThat(errorType.getSimpleName(),getErrorCount(errorType),is(expectedCount));
    }

    public void assertHasFrame(OpCode op)
    {
        Assert.assertThat(op.name(),getFrameCount(op),greaterThanOrEqualTo(1));
    }

    public void assertHasFrame(OpCode op, int expectedCount)
    {
        Assert.assertThat(op.name(),getFrameCount(op),is(expectedCount));
    }

    public void assertHasNoFrames()
    {
        Assert.assertThat("Has no frames",frames.size(),is(0));
    }

    public void assertNoErrors()
    {
        Assert.assertThat("Has no errors",errors.size(),is(0));
    }

    public int getErrorCount(Class<? extends WebSocketException> errorType)
    {
        int count = 0;
        for(WebSocketException error: errors) {
            if (errorType.isInstance(error))
            {
                count++;
            }
        }
        return count;
    }

    public List<WebSocketException> getErrors()
    {
        return errors;
    }

    public int getFrameCount(OpCode op)
    {
        int count = 0;
        for(WebSocketFrame frame: frames) {
            if (frame.getOpCode() == op)
            {
                count++;
            }
        }
        return count;
    }

    public List<WebSocketFrame> getFrames()
    {
        return frames;
    }

    @Override
    public void onFrame(WebSocketFrame frame)
    {
        frames.add(frame);
    }

    @Override
    public void onWebSocketException(WebSocketException e)
    {
        LOG.warn(e);
        errors.add(e);
    }
}