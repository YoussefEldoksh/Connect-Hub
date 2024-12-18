package backend;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author malak
 */
public class NotificationGroupAdd extends Notification {

    private String groupId;
    private String requesterId;

    public NotificationGroupAdd(String groupId, String requesterId, String id, String type, LocalDateTime time, String message) {
        super(id, type, message, time);
        this.requesterId = requesterId;
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getRequester() {
        return requesterId;
    }

    public static String lineRepresentation(String groupId, String requester) {

        return AccountManagement.findUsername(requester) + " joined Group: " + GroupSession.getCurrentGroup().getGroupName();
        //requester could be changed to be username not id

    }
}
