package ar.com.elegantsoft.breakingjpa.repo

import ar.com.elegantsoft.breakingjpa.domain.{Child, GreatChild, Parent}
import org.apache.logging.log4j.scala.Logging
import org.scalatest.{Matchers, WordSpec}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestContextManager

import scala.collection.JavaConverters._

@DataJpaTest
class GreatChildRepoTest extends WordSpec with Matchers with Logging {
  @Autowired
  val parentRepo: ParentRepo = null

  @Autowired
  val childRepo: ChildRepo = null

  @Autowired
  val gchildRepo: GreatChildRepo = null

  new TestContextManager(this.getClass).prepareTestInstance(this)

  "ParentRepo" should {
    "save" in {
      val p = new Parent("papa")
      parentRepo.save(p)
      val c = new Child("child", p)
      childRepo.save(c)
      gchildRepo.save(new GreatChild("gchild1", c))
      gchildRepo.count() shouldBe 1
    }

    "delete" in {
      val c1 = gchildRepo.findAll()
      c1 should have size 1
      gchildRepo.delete(c1.get(0))
      gchildRepo.count() shouldBe 0
    }

    "load" in {
      val all = gchildRepo.findAll()
      all should have size 3
    }

    "delete all" in {
      gchildRepo.count() shouldBe 3
      gchildRepo.deleteAll()
      gchildRepo.count() shouldBe 0
    }
  }
}
