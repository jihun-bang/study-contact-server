package jihun.bang.studycontact.controller

import jihun.bang.studycontact.model.Contact
import jihun.bang.studycontact.service.ContactService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class ContactController {
    @Autowired
    private lateinit var contactService: ContactService

    @GetMapping("/contacts")
    private fun getContacts(): ResponseEntity<Any> {
        println("[ContactController][getContacts][Start]")
        return ResponseEntity
            .ok()
            .body(contactService.getAllContacts().also { println("[ContactController][getContacts][Return] $it") })
    }

    @GetMapping("/contact/{id}")
    private fun getContactById(@PathVariable id: Int): ResponseEntity<Any> {
        println("[ContactController][getContactById][Start] id=$id")
        return ResponseEntity
            .ok()
            .body((contactService.getContact(id) ?: "id=$id, Get Failed").also { println("[ContactController][getContactById][Return] $it") })
    }

    @PostMapping("/contact")
    private fun addContact(@RequestBody model: Contact): ResponseEntity<Any> {
        println("[ContactController][addContact][Start] model=$model")
        return when (contactService.addContact(model)) {
            true -> ResponseEntity.ok().body("model=$model, Add Success".also { println("[ContactController][addContact][Return] $it") })
            false -> ResponseEntity.ok().body("model=$model, Add Fail".also { println("[ContactController][addContact][Return] $it") })
        }
    }

    @PutMapping("/contact/{id}")
    private fun updateContact(@PathVariable id: Int, @RequestBody model: Contact): ResponseEntity<Any> {
        println("[ContactController][addContact][Start] id=$id, model=$model")
        return when (contactService.updateContact(id, Contact(id = id, name = model.name, mail = model.mail))) {
            true -> ResponseEntity.ok().body("id=$id, Update Success".also { println("[ContactController][updateContact][Return] $it") })
            false -> ResponseEntity.ok().body("id=$id, Update Fail".also { println("[ContactController][updateContact][Return] $it") })
        }
    }

    @DeleteMapping("/contact/{id}")
    private fun deleteContact(@PathVariable id: Int): ResponseEntity<Any> {
        return when (contactService.deleteContact(id)) {
            true -> ResponseEntity.ok().body("id=$id, Delete Success".also { println("[ContactController][deleteContact][Return] $it") })
            false -> ResponseEntity.ok().body("id=$id, Delete Fail".also { println("[ContactController][deleteContact][Return] $it") })
        }
    }
}