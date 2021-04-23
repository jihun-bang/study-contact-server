package jihun.bang.studycontact.repository

import jihun.bang.studycontact.ContactModel
import org.springframework.data.repository.CrudRepository

interface Repository : CrudRepository<ContactModel, Int> {
    fun findByContactId(id: Int): ContactModel?

    fun findAllBy(): List<ContactModel>?
}