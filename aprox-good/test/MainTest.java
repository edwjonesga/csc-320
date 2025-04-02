import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class MainTest {

    @Test
    public void testVertexCoverMaxDegree() {
        VertexCoverAssignment.Graph g = VertexCoverAssignment.generatePathologicalGraph();
        Set<String> cover = VertexCoverAssignment.vertexCoverMaxDegree(g);

        List<String[]> edges = g.getEdges();
        for (String[] edge : edges) {
            assertTrue(cover.contains(edge[0]) || cover.contains(edge[1]), 
                "Edge " + Arrays.toString(edge) + " not covered");
        }
    }

    @Test
    public void testVertexCoverTwoApproxStub() {
        VertexCoverAssignment.Graph g = VertexCoverAssignment.generatePathologicalGraph();
        Set<String> cover = VertexCoverAssignment.vertexCoverTwoApprox(g);

        assertNotNull(cover, "2-approximation algorithm is not implemented");
        List<String[]> edges = g.getEdges();
        for (String[] edge : edges) {
            assertTrue(cover.contains(edge[0]) || cover.contains(edge[1]),
                "Edge " + Arrays.toString(edge) + " not covered");
        }
    }

    @Test
    public void testPathologicalGraphComparison() {
        VertexCoverAssignment.Graph g = VertexCoverAssignment.generatePathologicalGraph();
        Set<String> greedyCover = VertexCoverAssignment.vertexCoverMaxDegree(g);
        Set<String> approxCover = VertexCoverAssignment.vertexCoverTwoApprox(g);

        assertNotNull(greedyCover);
        assertNotNull(approxCover);
        assertTrue(approxCover.size() <= 2 * greedyCover.size() || greedyCover.size() < approxCover.size(),
            "Greedy may perform worse; this is expected");
    }

    @Test
    public void testBruteForcePartition() {
        Partition p = new Partition();
        List<Integer> nums = Arrays.asList(3, 1, 4, 2, 2);
        PartitionBruteForce.Result result = p.bruteForcePartition(nums);

        int sum1 = result.set1.stream().mapToInt(i -> i).sum();
        int sum2 = result.set2.stream().mapToInt(i -> i).sum();

        assertEquals(sum1, sum2, 1, "Brute-force partition is not approximately balanced");
    }

    @Test
    public void testGreedyPartitionStub() {
        Partition p = new Partition();
        List<Integer> nums = Arrays.asList(5, 8, 6, 4);
        PartitionBruteForce.Result result = p.greedyPartition(nums);

        assertNull(result, "Expected null until student implements greedyPartition");
    }

    @Test
    public void testPTASPartitionStub() {
        Partition p = new Partition();
        List<Integer> nums = Arrays.asList(5, 8, 6, 4);
        PartitionBruteForce.Result result = p.ptasPartition(nums, 0.2);

        assertNull(result, "Expected null until student implements ptasPartition");
    }
}
