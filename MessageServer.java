import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MessageServer {


    public static HashMap<Integer,Integer> regClient = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Queue> msgQ = new HashMap<Integer, Queue>();
    //register a client -- clientId , window
    public void registerClient(int clientId,int window)
    { //max registeration -10,000
        //max msg per client 100
        if(!(regClient.containsKey(clientId)))
        {
            if (MessageServer.regClient.size()<2)
            {
                regClient.put(clientId,window);
                Queue<Integer> clientMsgQueue = new LinkedList<Integer>();
                //register a queue for this client
                msgQ.put(clientId,clientMsgQueue);
                System.out.println("****registered client******* ");
            }
            else
            {
                System.out.println("registered client exceeded");
            }
        }


    }



    public void sendMessage(int clientId,int messageId, int age)
    {
        //send a new message --- clientId messageId message age
        //sending new message with decrease in window size
        //if the window is full add message to msg queue for that particular client

        //check if client is registered
        if(MessageServer.regClient.containsKey(clientId))
        {
            //check window size>0
            if (MessageServer.regClient.get(clientId)!=0)
            {
                System.out.println("hii the message sent to client is --- " + clientId +" " + messageId +" " +age);
                int decWindow = MessageServer.regClient.get(clientId) -1;
                MessageServer.regClient.put(clientId,decWindow);
                System.out.println("the new window size is ");
                System.out.println(MessageServer.regClient.get(clientId));

            }else
            {
                //if window size is zero then add message to message queue for that client
                System.out.println("the window size is zero for this client ");
                LinkedList<Integer> clientMsgQ = (LinkedList<Integer>) MessageServer.msgQ.get(clientId);
                clientMsgQ.add(messageId);
                System.out.println("size of message queue for this client is "+ clientMsgQ.size());
                MessageServer.msgQ.put(clientId,clientMsgQ);
            }
        }

    }


    public void adjustWindow(int clientId,int size)
    {
        // adjust window  -- increase the window size  for that particular client print the remaining message
        //check the message queue if there are any message for the client.

        //check if client is registered or not
        if (MessageServer.regClient.containsKey(clientId))
        {

            int win = size;

            MessageServer.regClient.put(clientId,win);
            System.out.println("increased window size");
            //check if there are message in the queue for this client
            if(MessageServer.msgQ.get(clientId).size()>0)
            {
                System.out.println("there are message for this client in the queue`");
                //till u have the window
                while(MessageServer.regClient.get(clientId)!=0 && MessageServer.msgQ.get(clientId).size()>0)
                {
                    System.out.println("sending message to client from queue ");
                    //decrease window size
                    if(MessageServer.msgQ.get(clientId).peek()!=null)
                    {
                        int message = (int) MessageServer.msgQ.get(clientId).peek();
                        System.out.println("client " + clientId);
                        System.out.println("message id "+message);
                        MessageServer.msgQ.get(clientId).remove();
                        MessageServer.regClient.put(clientId,(MessageServer.regClient.get(clientId)-1));

                    }


                }
            }
        }


    }

    public static void main(String[] args) {
        MessageServer msgServer = new MessageServer();
        msgServer.registerClient(1,2);
        msgServer.sendMessage(1,1,2);
        msgServer.sendMessage(1,2,3);
        msgServer.sendMessage(1,3,4);
        msgServer.sendMessage(1,4,5);
        msgServer.registerClient(2,1);
        msgServer.sendMessage(2,3,2);
        msgServer.sendMessage(2,1,3);
        msgServer.adjustWindow(2,2);
        msgServer.adjustWindow(1,4);
        msgServer.sendMessage(1,5,3);

    }



}

