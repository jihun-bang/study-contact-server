package jihun.bang.studycontact.service

import jihun.bang.studycontact.model.ContactModel
import jihun.bang.studycontact.repository.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ContactServiceImpl constructor(@Autowired private val repository: ContactRepository) : ContactService {
    override fun getAllContacts(): List<ContactModel> {
        return repository.findAll().toList().also { println("[getAllContacts] $this") }
    }

    override fun getContact(id: Int): ContactModel? {
        return repository.findById(id).orElse(null).also { println("[getContact] [Input] $id [Result] $this") }
    }

    @Transactional
    override fun addContact(model: ContactModel): Boolean {
        repository.save(model)
        return repository.findById(model.id).isPresent.also { println("[addContact] [Input] $model [Result] $this") }
    }

    @Transactional
    override fun updateContact(id: Int, model: ContactModel): Boolean {
        repository.findById(id).let { if (it.isPresent) repository.save(it.get()) }
        return repository.findById(id).isPresent.also { println("[updateContact] [Input] id=$id, model=$model [Result] $this") }
    }

    @Transactional
    override fun deleteContact(id: Int): Boolean {
        repository.findById(id).let { if (it.isPresent) repository.delete(it.get()) }
        return repository.findById(id).isPresent.also { println("[deleteContact] [Input] $id [Result] $this") }
    }
}