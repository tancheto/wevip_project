package bg.sofia.uni.fmi.piss.project.wevip.security;

public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    EVENT_READ("event:read"),
    EVENT_WRITE("event:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
