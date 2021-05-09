package jihun.bang.studycontact.service

import jihun.bang.studycontact.model.Contact
import jihun.bang.studycontact.repository.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ContactServiceImpl constructor(@Autowired private val repository: ContactRepository) : ContactService {
    override fun getAllContacts(): List<Contact> {
        return repository.findAll().toList().also { println("[ContactServiceImpl][getAllContacts] $it") }
    }

    override fun getContact(id: Int): Contact? {
        return repository.findById(id).orElse(null).also { println("[ContactServiceImpl][getContact] [Input] $id [Result] $it") }
    }

    @Transactional
    override fun addContact(model: Contact): Boolean {
        repository.save(model)
        return repository.findById(model.id).isPresent.also { println("[ContactServiceImpl][addContact] [Input] $model [Result] $it") }
    }

    @Transactional
    override fun updateContact(id: Int, model: Contact): Boolean {
        repository.findById(id).let {
            if (it.isPresent) {
                repository.delete(it.get())
                repository.save(model)
            }
        }
        return repository.findById(id).isPresent.also { println("[ContactServiceImpl][updateContact] [Input] id=$id, model=$model [Result] $it") }
    }

    @Transactional
    override fun deleteContact(id: Int): Boolean {
        repository.findById(id).let { if (it.isPresent) repository.delete(it.get()) }
        return repository.findById(id).isPresent.not().also { println("[ContactServiceImpl][deleteContact] [Input] $id [Result] $it") }
    }
}