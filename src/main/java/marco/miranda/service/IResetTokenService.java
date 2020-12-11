package marco.miranda.service;

import marco.miranda.model.ResetToken;

public interface IResetTokenService {
	
ResetToken findByToken(String token);
	
	void guardar(ResetToken token);
	
	void eliminar(ResetToken token);

}
