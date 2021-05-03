package jihun.bang.studycontact.service

import jihun.bang.studycontact.model.Contact
import org.springframework.stereotype.Service

@Service
interface ContactService {
    fun getAllContacts(): List<Contact>

    fun getContact(id: Int): Contact?

    fun addContact(model: Contact): Boolean

    fun updateContact(id: Int, model: Contact): Boolean

    fun deleteContact(id: Int): Boolean
}