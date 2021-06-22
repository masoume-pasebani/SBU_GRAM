package Common;

import java.io.Serializable;

public enum Command implements Serializable {
    login,
    logout,
    signup,
    update_profile,
    block,
    username_unique,
    pass_recovery,
}
