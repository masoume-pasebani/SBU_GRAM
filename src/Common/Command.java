package Common;

import java.io.Serializable;

public enum Command implements Serializable {
    /**
     * these are some commands that user will do
     */
    login,
    logout,
    signup,
    update_profile,
    true_phonenumber,
    show_list_posts,
    like,
    dislike,
    search,
    get_posts,
    allPosts,
    block,
    username_unique,
    pass_recovery,
    publish_post,
}
