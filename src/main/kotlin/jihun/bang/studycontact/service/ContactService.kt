package jihun.bang.studycontact.service

import jihun.bang.studycontact.model.ContactModel
import org.springframework.stereotype.Service

@Service
interface ContactService {
    fun getAllContacts(): List<ContactModel>

    fun getContact(id: Int): ContactModel?

    fun addContact(model: ContactModel): Boolean

    fun updateContact(id: Int, model: ContactModel): Boolean

    fun deleteContact(id: Int): Boolean
}