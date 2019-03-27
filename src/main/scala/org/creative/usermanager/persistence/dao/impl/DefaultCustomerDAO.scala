package org.creative.usermanager.persistence.dao.impl

import org.creative.usermanager.persistence.SchemaCreatorImpl
import org.creative.usermanager.persistence.dao.CustomerDAO
import org.creative.usermanager.persistence.entity.Customer
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

class DefaultCustomerDAO extends CustomerDAO {
  this: SchemaCreatorImpl =>

  override def save(customer: Customer): Unit = {
    db.run(customers += customer)
  }

  override def getAll(): Future[Seq[Customer]] = {

    db.run(customers.result)
  }

  override def getById(id: Int): Future[Seq[Customer]] = {
    db.run(customers.filter(_.userId === id).result)
  }
}