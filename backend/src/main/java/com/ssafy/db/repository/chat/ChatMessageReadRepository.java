package com.ssafy.db.repository.chat;

import com.ssafy.db.entity.chat.ChatMessage;
import com.ssafy.db.entity.chat.ChatMessageRead;
import com.ssafy.db.entity.chat.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatMessageReadRepository extends JpaRepository<ChatMessageRead, Long> {

    /* 현재 user가 채팅방에서 읽지않은 메시지의 개수 가져오기 */
    @Query(
            value = "SELECT * FROM chat_message_read WHERE room_id = :roomId and isRead = false GROUP BY user_id = :userId",
            nativeQuery = true
    )
    Optional<List<ChatMessageRead>> findChatMessageReadsByRoomIdAndUserId(ChatRoom roomId, String userId);

    @Transactional
    @Query(
            value = "UPDATE chat_message_read SET isRead = true WHERE room_id = :roomId and isRead = false and user_id = :userId",
            nativeQuery = true
    )
    void updateIsRead(ChatRoom roomId, String userId);

}
