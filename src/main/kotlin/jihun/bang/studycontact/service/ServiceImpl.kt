package jihun.bang.studycontact.service

import jihun.bang.studycontact.ContactModel
import jihun.bang.studycontact.repository.Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ContactServiceImpl constructor(@Autowired private val repository: Repository) :
    ContactService {

    override fun getAllContacts(): List<ContactModel>? =
        repository.findAllBy()

    override fun getContact(id: Int): ContactModel? =
        repository.findByContactId(id)

    @Transactional
    override fun addContact(model: ContactModel): ContactModel =
        repository.save(model)

}