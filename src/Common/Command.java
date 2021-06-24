package Common;

import java.io.Serializable;

public enum Command implements Serializable {
    login,
    logout,
    signup,
    update_profile,
    true_phonenumber,
    show_list_posts,
    like,
    dislike,
    block,
    username_unique,
    pass_recovery,
    publish_post,
}
