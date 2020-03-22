package com.company;

import java.io.IOException;

public class OuterServer {

    static final int MAIN_OUTER_SERVER_PORT = 2000;
    static final int BALANCER_PORT = 3000;
    static final int HANDLER_FIRST_PORT = 2010;
    static final int HANDLER_SECOND_PORT = 2020;
    static final int HANDLER_THIRD_PORT = 2030;

    public static void main(String[] args) throws IOException {

        //TCP connection with Client - receiving the tasks
        TCP_Client_Connection tcp_client_connection = new TCP_Client_Connection(MAIN_OUTER_SERVER_PORT, BALANCER_PORT, HANDLER_FIRST_PORT, HANDLER_SECOND_PORT, HANDLER_THIRD_PORT);
        tcp_client_connection.receiveTaskFromClient();

    }
}

