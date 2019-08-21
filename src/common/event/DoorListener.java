package common.event;

import java.util.EventListener;

public interface DoorListener extends EventListener {
    void onMessage(String message);
}