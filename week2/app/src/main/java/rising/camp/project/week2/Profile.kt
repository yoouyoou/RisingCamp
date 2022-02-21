package rising.camp.project.week2

import android.graphics.drawable.Drawable
import java.io.Serializable

data class Profile(
    var profileImage: Drawable?,
    var backImage: Drawable?,
    var name: String,
    val music: String
) : Serializable