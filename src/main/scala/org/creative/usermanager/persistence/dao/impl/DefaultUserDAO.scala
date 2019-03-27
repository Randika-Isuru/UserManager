package org.creative.usermanager.persistence.dao.impl

import org.creative.usermanager.persistence.SchemaCreatorImpl
import org.creative.usermanager.persistence.dao.UserDAO
import org.creative.usermanager.persistence.entity.User
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

class DefaultUserDAO extends UserDAO {
  this: SchemaCreatorImpl =>

  override def save(user: User): Unit = {
    db.run(users += user)
  }

  override def getAll(): Future[Seq[User]] = {

    db.run(users.result)
  }

  override def getById(id: Int): Future[Seq[User]] = {

    db.run(users.filter(_.id === id).result)
  }
}