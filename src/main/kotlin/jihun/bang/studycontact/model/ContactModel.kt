package jihun.bang.studycontact.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class ContactModel(
    @Id
    @GeneratedValue
    val id: Int = 0,
    val name: String = "",
    val mail: String = ""
)