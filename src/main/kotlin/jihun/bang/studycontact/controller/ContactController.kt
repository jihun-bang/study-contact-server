package jihun.bang.studycontact.controller

import jihun.bang.studycontact.ContactModel
import jihun.bang.studycontact.service.ContactService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class ContactController {
    @Autowired
    private lateinit var contactService: ContactService

    @GetMapping("/templates")
    private fun getTemplates(): ResponseEntity<Any> {
        return ResponseEntity
            .ok()
            .body(contactService.getAllContacts())
    }

    @GetMapping("/template/{id}")
    private fun getTemplateById(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity
            .ok()
            .body(contactService.getContact(id))
    }

    @PostMapping("/template")
    private fun postTemplate(@RequestBody model: ContactModel): ResponseEntity<Any> {
        contactService.addContact(model)
        return ResponseEntity
            .ok()
            .body(true)
    }
}