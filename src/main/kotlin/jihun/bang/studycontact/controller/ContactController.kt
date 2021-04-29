package jihun.bang.studycontact.controller

import jihun.bang.studycontact.model.ContactModel
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
        return ResponseEntity
            .ok()
            .body(contactService.getAllContacts())
    }

    @GetMapping("/contact/{id}")
    private fun getContactById(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity
            .ok()
            .body(contactService.getContact(id) ?: "id=$id, Get Failed")
    }

    @PostMapping("/contact")
    private fun addContact(@RequestBody model: ContactModel): ResponseEntity<Any> {
        return when (contactService.addContact(model)) {
            true -> ResponseEntity.ok().body("model=$model, Add Success")
            false -> ResponseEntity.ok().body("model=$model, Add Fail")
        }
    }

    @PutMapping("/contact/{id}")
    private fun updateContact(@PathVariable id: Int, @RequestBody model: ContactModel): ResponseEntity<Any> {
        return when (contactService.updateContact(id, model)) {
            true -> ResponseEntity.ok().body("id=$id, Update Success")
            false -> ResponseEntity.ok().body("id=$id, Update Fail")
        }
    }

    @DeleteMapping("/contact/{id}")
    private fun deleteContact(@PathVariable id: Int): ResponseEntity<Any> {
        return when (contactService.deleteContact(id)) {
            true -> ResponseEntity.ok().body("id=$id, Delete Success")
            false -> ResponseEntity.ok().body("id=$id, Delete Fail")
        }
    }
}