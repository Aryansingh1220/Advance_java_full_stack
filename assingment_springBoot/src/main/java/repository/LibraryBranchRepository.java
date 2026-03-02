package repository;
import entity.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryBranchRepository extends JpaRepository<LibraryBranch, Long> {
}