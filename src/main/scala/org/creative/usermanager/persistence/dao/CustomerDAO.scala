package org.creative.usermanager.persistence.dao

import org.creative.usermanager.persistence.entity.Customer

import scala.concurrent.Future

trait CustomerDAO {

  def save(customer: Customer): Unit

  def getAll(): Future[Seq[Customer]]

  def getById(id: Int): Future[Seq[Customer]]
}