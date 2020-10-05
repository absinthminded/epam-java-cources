package com.epam.university.java.core.task031;

import java.io.IOException;

/**
 * Networking with streams.
 */
public interface Task031 {
    /**
     * Create chat client.
     * @return chat client instance
     */
    Client createClient() throws IOException;

    /**
     * Create chat server.
     * @return chat server instance
     */
    Server createServer() throws IOException;
}
