package jihun.bang.studycontact.service

import jihun.bang.studycontact.ContactModel
import org.springframework.stereotype.Service

@Service
interface ContactService {
    fun getAllContacts(): List<ContactModel>?

    fun getContact(id: Int): ContactModel?

    fun addContact(model: ContactModel): ContactModel
}