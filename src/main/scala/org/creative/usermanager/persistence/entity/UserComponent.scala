package org.creative.usermanager.persistence.entity

import slick.jdbc.PostgresProfile.api._
import slick.lifted.ProvenShape


case class User(id: Int,
                name: String,
                username: String,
                password: String)

trait UserComponent {

  class UserTable(tag: Tag) extends Table[(User)](tag, _tableName = "user") {

    def id: Rep[Int] = column[Int]("id", O.PrimaryKey)

    def name: Rep[String] = column[String]("name")

    def username: Rep[String] = column[String]("username")

    def password: Rep[String] = column[String]("password")

    def * : ProvenShape[User] = (id, name, username, password) <> (User.tupled, User.unapply)
  }

  val users = TableQuery[UserTable]

}