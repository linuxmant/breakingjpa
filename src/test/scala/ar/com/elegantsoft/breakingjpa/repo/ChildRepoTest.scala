package ar.com.elegantsoft.breakingjpa.repo

import ar.com.elegantsoft.breakingjpa.domain.{Child, Parent}
import org.apache.logging.log4j.scala.Logging
import org.scalatest.{Matchers, WordSpec}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestContextManager

import scala.collection.JavaConverters._

@DataJpaTest
class ChildRepoTest extends WordSpec with Matchers with Logging {
  @Autowired
  val parentRepo: ParentRepo = null

  @Autowired
  val childRepo: ChildRepo = null

  new TestContextManager(this.getClass).prepareTestInstance(this)

  "ParentRepo" should {
    "save" in {
      val p = new Parent("papa")
      childRepo.save(new Child("child1", p))
      childRepo.count() shouldBe 1
    }

    "delete" in {
      val c1 = childRepo.findAll().get(0)
      childRepo.delete(c1)
      childRepo.count() shouldBe 0
    }

    "load" in {
      val p1 = new Parent("p1")
      parentRepo.save(p1)
      val cs = Seq(new Child("child1", p1), new Child("child2", p1), new Child("child3", p1))
      childRepo.saveAll(cs.asJava)
      val all = childRepo.findAll()
      all should have size 3
      all shouldBe cs.asJava
    }

    "find by name" in {
      val c = childRepo.findAllByCname("child1")
      c should have size 1
      c.get(0).getCname shouldBe "child1"
    }

    "delete all" in {
      childRepo.count() shouldBe 4
      childRepo.deleteAll()
      childRepo.count() shouldBe 0
    }
  }
}
