package jihun.bang.studycontact

import org.springframework.data.annotation.Id
import javax.persistence.GeneratedValue

data class ContactModel(
    @Id @GeneratedValue
    val id: Int = 0,
    val name: String = "",
    val mail: String = ""
)