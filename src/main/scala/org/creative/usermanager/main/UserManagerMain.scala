package org.creative.usermanager.main

import org.creative.usermanager.persistence.SchemaCreatorImpl
import org.creative.usermanager.persistence.dao.impl.{DefaultCustomerDAO, DefaultUserDAO}
import org.creative.usermanager.persistence.entity.{Customer, User}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object UserManagerMain extends App {

  private val userDAO = new DefaultUserDAO () with SchemaCreatorImpl

  userDAO.save(User(123, "Supun", "SupunT", "1234567"))
  userDAO.save(User(124, "Maneesha", "ManeeshaR", "321654"))

  private val customerDAO = new DefaultCustomerDAO() with SchemaCreatorImpl

  customerDAO.save(Customer("1", "Randika", "AAAAA", "123456789", 123))
  customerDAO.save(Customer("2", "Isuru", "BBBBB", "987654321", 124))
  customerDAO.save(Customer("3", "Cijayanga", "CCCCC", "123456789", 124))

  private val eventualUserSeq: Future[Seq[User]] = userDAO.getAll()
  val awaitUser = Await.result(eventualUserSeq, Duration.Inf)
  awaitUser.map(user =>
    println("Users List :- user id : "+user.id+" user name : "+ user.name )
  )

  private val eventualCustomers: Future[Seq[Customer]] = customerDAO.getAll()
  private val customers: Seq[Customer] = Await.result(eventualCustomers, Duration.Inf )
  customers.map(customer =>
    println(" Customer List :- Customer ID : "+ customer.id + " Customer Name : "+ customer.name )
  )
}

