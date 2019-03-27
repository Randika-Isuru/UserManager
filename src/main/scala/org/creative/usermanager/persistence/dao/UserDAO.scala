package org.creative.usermanager.persistence.dao

import org.creative.usermanager.persistence.entity.User

import scala.concurrent.Future

trait UserDAO {

  def save(user: User): Unit

  def getAll(): Future[Seq[User]]

  def getById(id: Int): Future[Seq[User]]
}