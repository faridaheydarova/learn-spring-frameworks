package malikzadeibrahim.ibrahim;

import malikzadeibrahim.ibrahim.entity.Computer;
import malikzadeibrahim.ibrahim.repo.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    public Optional<Computer> getComputerById(Long id) {
        return computerRepository.findById(id);
    }

    public Computer addComputer(Computer computer) {
        return computerRepository.save(computer);
    }

    public Computer updateComputer(Long id, Computer computer) {
        if (computerRepository.existsById(id)) {
            computer.setId(id);
            return computerRepository.save(computer);
        }
        return null;
    }

    public boolean deleteComputer(Long id) {
        if (computerRepository.existsById(id)) {
            computerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
