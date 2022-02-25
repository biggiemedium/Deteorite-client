package dev.px.deteorite.Util;

import dev.px.deteorite.Event.Handler.EventProcessor;

public class TPSUtil {

    public TPSUtil() {
        EventProcessor.subscribe(this);
    }

    public static TPSUtil INSTANCE = new TPSUtil();
}
