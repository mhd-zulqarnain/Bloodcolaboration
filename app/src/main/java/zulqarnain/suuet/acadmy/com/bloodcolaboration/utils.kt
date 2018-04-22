package zulqarnain.suuet.acadmy.com.bloodcolaboration

import android.content.Context
import android.widget.Toast

/**
 * Created by Zul Qarnain on 4/22/2018.
 */

class utils {
    companion object {
        fun messege(ctx: Context, msg: String) {
            Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
        }

        fun isnull(text: String): Boolean {
            if (text.equals("")) {
                return true
            }
            return false
        }
    }

}
