package com.example.himaps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.hyphenate.EMMessageListener;
import com.hyphenate.EMValueCallBack;
import com.hyphenate.chat.EMChatRoom;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;

import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private EditText editText;
    private String username = "lucas";
    private String opponent = "";
    private MessageAdapter adapter;
    private ListView listview;
    private boolean isRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Bundle bundle = this.getIntent().getExtras();
        username = bundle.getString("user");
        isRoom = bundle.getBoolean("isroom");
        opponent = bundle.getString("oppo");
        editText = findViewById(R.id.editText);
        listview = findViewById(R.id.messages_view);
        adapter = new MessageAdapter(this);
        listview.setAdapter(adapter);
        if(isRoom)
        EMClient.getInstance().chatroomManager().joinChatRoom("120445940596738", new EMValueCallBack<EMChatRoom>() {
            @Override
            public void onSuccess(EMChatRoom emChatRoom) {
                Toast.makeText(getApplicationContext(), "Join room success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(int i, String s) {
                Toast.makeText(getApplicationContext(), "Join room failed", Toast.LENGTH_SHORT).show();

            }
        });
        EMClient.getInstance().chatManager().addMessageListener(new EMMessageListener() {
            @Override
            public void onMessageReceived(List<EMMessage> messages) {
                for(EMMessage receivedMessage : messages) {
                    boolean belongsToCurrentUser = receivedMessage.getUserName().equals(username);
                    EMTextMessageBody body = (EMTextMessageBody)receivedMessage.getBody();
                    final Message message = new Message(body.getMessage(),
                            new MemberData(receivedMessage.getUserName()),belongsToCurrentUser);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.add(message);
                            // scroll the ListView to the last added element
                            listview.setSelection(listview.getCount() - 1);
                        }
                    });
                }
            }

            @Override
            public void onCmdMessageReceived(List<EMMessage> messages) {

            }

            @Override
            public void onMessageRead(List<EMMessage> messages) {

            }

            @Override
            public void onMessageDelivered(List<EMMessage> messages) {

            }

            @Override
            public void onMessageRecalled(List<EMMessage> messages) {

            }

            @Override
            public void onMessageChanged(EMMessage message, Object change) {

            }
        });
    }

    public void sendMessage(View view) {
        String message = editText.getText().toString();
        if (message.length() > 0) {
            EMMessage msg = null;
            if (isRoom) msg = EMMessage.createTxtSendMessage(message, "120445940596738");
            else msg=EMMessage.createTxtSendMessage(message,opponent);
            if(isRoom)msg.setChatType(EMMessage.ChatType.ChatRoom);
            else msg.setChatType(EMMessage.ChatType.Chat);
            EMClient.getInstance().chatManager().sendMessage(msg);
            editText.getText().clear();
            final Message msg2 = new Message(message,
                    new MemberData(username),true);
            runOnUiThread(() -> {
                adapter.add(msg2);
                // scroll the ListView to the last added element
                listview.setSelection(listview.getCount() - 1);
            });
        }
    }
}