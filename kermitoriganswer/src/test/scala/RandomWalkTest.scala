class RandomWalkTest extends munit.FunSuite {
  test("Acceptance Test 1") {
    val dimension = 2
    val simulation = RandomWalk()
    simulation.start(dimension)
    val expectedPath = Path()
    // expectedPath: (1, 0), (0, 0), (1, 0), (0, 0), (1, 0), (1, 1), (1, 0), (1, 1), (0, 1)
    expectedPath.addCell(Cell(1, 0))
    expectedPath.addCell(Cell(0, 0))
    expectedPath.addCell(Cell(1, 0))
    expectedPath.addCell(Cell(0, 0))
    expectedPath.addCell(Cell(1, 0))
    expectedPath.addCell(Cell(1, 1))
    expectedPath.addCell(Cell(1, 0))
    expectedPath.addCell(Cell(1, 1))
    expectedPath.addCell(Cell(0, 1))
    val obtainedPath = simulation.path
    val expectedNoOfHops = 9
    val obtainedNoOfHops = simulation.noOfHops
    val expectedNoOfRolls = 23
    val obtainedNoOfRolls = simulation.noOfRolls
    assert(obtainedPath == expectedPath)
    assert(obtainedNoOfHops == expectedNoOfHops)
    assert(expectedNoOfRolls == obtainedNoOfRolls)
  }
  test("1x1 Grid") {
    val dimension = 1
    val simulation = RandomWalk()
    simulation.start(dimension)
    val expectedPath = Path()
    val obtainedPath = simulation.path
    val expectedNoOfHops = 0
    val obtainedNoOfHops = simulation.noOfHops
    val expectedNoOfRolls = 0
    val obtainedNoOfRolls = simulation.noOfRolls
    assert(obtainedPath == expectedPath)
    assert(obtainedNoOfHops == expectedNoOfHops)
    assert(expectedNoOfRolls == obtainedNoOfRolls)
  }

  test("2x2 Grid") {
    val dimension = 2
    val simulation = RandomWalk()
    simulation.start(dimension)
    val expectedPath = Path()
    // expectedPath: (1, 0), (0, 0), (1, 0), (0, 0), (1, 0), (1, 1), (1, 0), (1, 1), (0, 1)
    expectedPath.addCell(Cell(1, 0))
    expectedPath.addCell(Cell(0, 0))
    expectedPath.addCell(Cell(1, 0))
    expectedPath.addCell(Cell(0, 0))
    expectedPath.addCell(Cell(1, 0))
    expectedPath.addCell(Cell(1, 1))
    expectedPath.addCell(Cell(1, 0))
    expectedPath.addCell(Cell(1, 1))
    expectedPath.addCell(Cell(0, 1))
    val obtainedPath = simulation.path
    val expectedNoOfHops = 9
    val obtainedNoOfHops = simulation.noOfHops
    val expectedNoOfRolls = 23
    val obtainedNoOfRolls = simulation.noOfRolls
    assert(obtainedPath == expectedPath)
    assert(obtainedNoOfHops == expectedNoOfHops)
    assert(expectedNoOfRolls == obtainedNoOfRolls)
  }

  test("4x4 Grid") {
    val dimension = 4
    val simulation = RandomWalk()
    simulation.start(dimension)
    val expectedPath = Path()
    val expectedPoints = Array((1, 0), (0, 0), (1, 0), (0, 0), (1, 0), (2, 0), (2, 1), (3, 1), (3, 0), (3, 1), (3, 2), (2, 2), (3, 2), (3, 1), (3, 0), (3, 1), (3, 0), (3, 1), (2, 1), (2, 0), (2, 1), (1, 1), (2, 1), (3, 1), (3, 2), (3, 1), (2, 1), (3, 1), (3, 0), (3, 1), (3, 0), (3, 1), (3, 0), (2, 0), (3, 0), (3, 1), (2, 1), (2, 2), (1, 2), (2, 2), (1, 2), (0, 2), (1, 2), (2, 2), (3, 2), (3, 1), (2, 1), (3, 1), (3, 0), (3, 1), (3, 2), (3, 1), (3, 0), (2, 0), (2, 1), (2, 0), (3, 0), (3, 1), (3, 2), (2, 2), (3, 2), (3, 3), (2, 3), (1, 3), (1, 2), (1, 1), (0, 1), (1, 1), (1, 0), (1, 1), (1, 0), (0, 0), (0, 1), (1, 1), (0, 1), (0, 0), (0, 1), (1, 1), (2, 1), (1, 1), (1, 2), (1, 1), (2, 1), (1, 1), (1, 2), (2, 2), (1, 2), (0, 2), (1, 2), (0, 2), (1, 2), (2, 2), (2, 3), (3, 3), (2, 3), (2, 2), (3, 2), (2, 2), (2, 1), (3, 1), (3, 2), (3, 1), (2, 1), (2, 2), (2, 1), (1, 1), (0, 1), (0, 0), (0, 1), (1, 1), (1, 2), (2, 2), (2, 1), (2, 0), (1, 0), (1, 1), (0, 1), (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (2, 1), (2, 0), (1, 0), (0, 0), (1, 0), (0, 0), (0, 1), (0, 0), (1, 0), (2, 0), (1, 0), (1, 1), (1, 2), (1, 3), (1, 2), (2, 2), (2, 3), (1, 3), (2, 3), (2, 2), (2, 1), (2, 2), (2, 3), (3, 3), (3, 2), (2, 2), (1, 2), (1, 3), (0, 3))
    for point <- expectedPoints do
      expectedPath.addCell(Cell(point._1, point._2))
    val obtainedPath = simulation.path
    val expectedNoOfHops = 151
    val obtainedNoOfHops = simulation.noOfHops
    val expectedNoOfRolls = 206
    val obtainedNoOfRolls = simulation.noOfRolls
    assert(obtainedPath == expectedPath)
    assert(obtainedNoOfHops == expectedNoOfHops)
    assert(expectedNoOfRolls == obtainedNoOfRolls)
  }
}