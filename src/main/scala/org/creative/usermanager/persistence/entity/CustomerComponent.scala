package org.creative.usermanager.persistence.entity

import slick.jdbc.PostgresProfile.api._
import slick.lifted.ProvenShape

case class Customer(id: String,
                    name: String,
                    address: String,
                    uuid: String,
                    userId: Int)

trait CustomerComponent {
  _: UserComponent =>

  class CustomerTable(tag: Tag) extends Table[Customer](tag, _tableName = "Customer") {

    def id: Rep[String] = column[String]("id", O.PrimaryKey)

    def name: Rep[String] = column[String]("name")

    def address: Rep[String] = column[String]("address")

    def uuid: Rep[String] = column[String]("uuid")

    def userId: Rep[Int] = column[Int]("user_id")

    def * : ProvenShape[Customer] = (id, name, address, uuid, userId) <> (Customer.tupled, Customer.unapply)

    def userForeignKey = foreignKey(name = "user_fk", userId, TableQuery[UserTable])(_.id)
  }

  val customers = TableQuery[CustomerTable]
}