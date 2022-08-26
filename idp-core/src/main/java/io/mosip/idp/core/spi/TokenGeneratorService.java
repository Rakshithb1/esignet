package io.mosip.idp.core.spi;

import io.mosip.idp.core.dto.IdPTransaction;

import java.util.List;

public interface TokenGeneratorService {

    String ISS = "iss";
    String SUB = "sub";
    String AUD = "aud";
    String EXP = "exp";
    String IAT = "iat";
    String AUTH_TIME = "auth_time";
    String NONCE = "nonce";
    String ACR = "acr";
    String JTI = "jti";
    String SCOPE = "scope";
    String ACCESS_TOKEN_HASH = "at_hash";


    /**
     * iss: REQUIRED. Issuer Identifier for the Issuer of the response. The iss value is a case sensitive URL using
     * the https scheme that contains scheme, host, and optionally, port number and path components and no query or
     * fragment components.
     *
     * sub: REQUIRED. Subject Identifier. Partner specific user token.
     *
     * aud: REQUIRED. Audience(s) that this ID Token is intended for. client_id of the Relying Party as an audience value.
     *
     * exp: REQUIRED. Expiration time on or after which the ID Token MUST NOT be accepted for processing. Its value is a
     * JSON number representing the number of seconds from 1970-01-01T0:0:0Z as measured in UTC until the date/time.
     *
     * iat: REQUIRED. Time at which the JWT was issued. Its value is a JSON number representing the number of seconds
     * from 1970-01-01T0:0:0Z as measured in UTC until the date/time.
     *
     * auth_time: Time when the End-User authentication occurred. Its value is a JSON number representing the number of
     * seconds from 1970-01-01T0:0:0Z as measured in UTC until the date/time.
     *
     * nonce: String value used to associate a Client session with an ID Token, and to mitigate replay attacks. The value is
     * passed through unmodified from the Authentication Request to the ID Token.
     *
     * acr: String specifying an Authentication Context Class Reference value that identifies the Authentication Context
     * Class that the authentication performed satisfied.
     *
     * at_hash: Access token hash
     * @return
     */
     String getIDToken(IdPTransaction transaction);

     List<String> getOptionalIdTokenClaims();

    /**
     * Access token need not have any user information, only need to have information about what
     * resources are allowed to access and within what time.
     *
     * iss: REQUIRED. Issuer Identifier for the Issuer of the response. The iss value is a case sensitive URL using
     * the https scheme that contains scheme, host, and optionally, port number and path components and no query or
     * fragment components.
     *
     * sub: REQUIRED. Subject Identifier. Partner specific user token.
     *
     * aud: REQUIRED. Audience(s) that this ID Token is intended for. client_id of the Relying Party as an audience value.
     *
     * exp: REQUIRED. Expiration time on or after which the ID Token MUST NOT be accepted for processing. Its value is a
     * JSON number representing the number of seconds from 1970-01-01T0:0:0Z as measured in UTC until the date/time.
     *
     * iat: REQUIRED. Time at which the JWT was issued. Its value is a JSON number representing the number of seconds
     * from 1970-01-01T0:0:0Z as measured in UTC until the date/time.
     *
     * jti: OPTIONAL. The jti (JWT ID) claim provides a unique identifier for the JWT. The identifier value MUST be
     * assigned in a manner that ensures that there is a negligible probability that the same value will be accidentally
     * assigned to a different data object. The jti claim can be used to prevent the JWT from being replayed. The jti
     * value is case-sensitive. This claim is OPTIONAL.
     *
     * scope: REQUIRED. The list of OAuth scopes this token includes
     *
     * @param transaction
     * @return
     */
     String getAccessToken(IdPTransaction transaction);
}
