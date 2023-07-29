package com.example.newanimals.fragment.messanger;

import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.newanimals.R;
import com.example.newanimals.db.MessageData;
import com.example.newanimals.fragment.BaseFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.BindView;

public class MessangerFragment extends BaseFragment {
    @BindView(R.id.listView)
    ListView lv;
    @BindView(R.id.send)
    Button send;
    @BindView(R.id.message)
    EditText message;
    private DatabaseReference databaseReference;
    private ArrayList<MessageData> messageList;
    private ArrayAdapter<MessageData> messageAdapter;
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void initViews() {
        super.initViews();
        user = auth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("messages");
        messageList = new ArrayList<>();
        messageAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, messageList);
        lv.setAdapter(messageAdapter);
        loadMessages();
        send.setOnClickListener(l->{
            String messages = message.getText().toString().trim();
            if(!messages.isEmpty()){
                databaseReference.push().setValue(messages);

            }
        });

    }

    private void loadMessages() {
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                MessageData data = snapshot.getValue(MessageData.class);
                if(data!=null){
                    messageList.add(data);
                    messageAdapter.notifyDataSetChanged();
                    lv.setSelection(messageList.size()-1);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void onSendMessage(View view){
        String msgText = message.getText().toString().trim();
        if(!TextUtils.isEmpty(msgText)){
            sendMessageToDB(msgText);
        }
    }

    private void sendMessageToDB(String msgText) {
        DatabaseReference databaseReference1 = databaseReference.push();
        String messageId = databaseReference1.getKey();
        if(messageId!=null){
            long timeStamp = System.currentTimeMillis();
            MessageData messageData = new MessageData(messageId, user.getUid(), msgText, timeStamp);
            databaseReference1.setValue(messageData)
                    .addOnSuccessListener(aVoid-> message.setText(""))
                    .addOnFailureListener(e->showToast("Ошибка отправки сообщения"));
        }
    }

    private void showToast(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    public static MessangerFragment newInstance() {
        return new MessangerFragment();
    }
    @Override
    protected int layoutId() {
        return R.layout.messanger_fragment;
    }
}
