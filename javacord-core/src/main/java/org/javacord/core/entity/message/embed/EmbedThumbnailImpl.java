package org.javacord.core.entity.message.embed;

import com.fasterxml.jackson.databind.JsonNode;
import org.javacord.api.entity.message.embed.EmbedThumbnail;
import org.javacord.core.util.logging.LoggerUtil;
import org.slf4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * The implementation of {@link EmbedThumbnail}.
 */
public class EmbedThumbnailImpl implements EmbedThumbnail {

    /**
     * The logger of this class.
     */
    private static final Logger logger = LoggerUtil.getLogger(EmbedThumbnailImpl.class);

    private String url;
    private String proxyUrl;
    private int height;
    private int width;

    /**
     * Creates a new embed thumbnail.
     *
     * @param data The json data of the thumbnail.
     */
    public EmbedThumbnailImpl(JsonNode data) {
        url = data.has("url") ? data.get("url").asText() : null;
        proxyUrl = data.has("proxy_url") ? data.get("proxy_url").asText() : null;
        height = data.has("height") ? data.get("height").asInt() : -1;
        width = data.has("width") ? data.get("width").asInt() : -1;
    }

    @Override
    public URL getUrl() {
        if (url == null) {
            return null;
        }
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            logger.warn("Seems like the url of the embed thumbnail is malformed! Please contact the developer!", e);
            return null;
        }
    }

    @Override
    public URL getProxyUrl() {
        if (proxyUrl == null) {
            return null;
        }
        try {
            return new URL(proxyUrl);
        } catch (MalformedURLException e) {
            logger.warn("Seems like the proxy url of the embed thumbnail is malformed! Please contact the developer!", e);
            return null;
        }
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

}