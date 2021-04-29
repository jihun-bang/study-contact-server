package jihun.bang.studycontact.repository

import jihun.bang.studycontact.model.ContactModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository : CrudRepository<ContactModel, Int>