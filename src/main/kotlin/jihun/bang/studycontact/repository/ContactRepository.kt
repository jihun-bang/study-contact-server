package jihun.bang.studycontact.repository

import jihun.bang.studycontact.model.Contact
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository : CrudRepository<Contact, Int>